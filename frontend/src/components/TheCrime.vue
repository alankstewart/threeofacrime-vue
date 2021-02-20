<template>
<div class="container">
    <h2>Three Of A Crime</h2>
    <div id="suspects" role="group">
    <b-form-group label="Suspects">
          <b-form-checkbox-group
            size="sm"
            id="suspects"
            v-model="selectedSuspects"
            :options="suspects"
            name="suspects">
          </b-form-checkbox-group>
        </b-form-group>
    </div>
    <br>
    <div id="matches" class="btn-group">
        <b-form-group label="Matches">
          <b-form-radio v-model="selectedMatch" name="match" value="0">0</b-form-radio>
          <b-form-radio v-model="selectedMatch" name="match" value="1">1</b-form-radio>
          <b-form-radio v-model="selectedMatch" name="match" value="2">2</b-form-radio>
        </b-form-group>
    </div>
    <br>
    <br>
    <button id="submit" type="button" class="btn btn-primary" v-on:click="matchSuspects">Match Suspects</button>
    <button id="clear" type="button" class="btn btn-success" v-on:click="clearSelections">Clear Selections</button>
    <button id="startNewGame" type="button" class="btn btn-warning">Start New Game</button>
    <br>
    <br>
    <div class="card text-white bg-info">
        <div class="card-header">Possible Suspect Cards</div>
        <div id="results" class="card-body">
            <div v-for="suspectCard in results" v-bind:key="suspectCard.id">{{suspectCard}}</div>
        </div>
    </div>
    <div id="fifty-fifty" v-if="results.length == 2" class="alert alert-warning">
        <strong>Warning!</strong> 50-50
    </div>
    <div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Start a new game?</h3>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button id="reset" type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="accusation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Accusation!</h3>
                </div>
                <div class="modal-body">
                    <div id="criminals" class="alert alert-success" role="alert"></div>
                </div>
                <div class="modal-footer">
                    <button id="startNewRound" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {
  name: 'ThreeOfACrime',
  data() {
    return {
      selectedSuspects: [],
      suspects: [],
      results: [],
      errors: [],
      suspectsLocal: [
       { text: "HUMPTY BUMPTY", value: "HUMPTY_BUMPTY" },
       { text: "JONNY CORTEX", value: "JONNY_CORTEX" },
       { text: "KID CASSIDY", value: "KID_CASSIDY" },
       { text: "LOOSE-EYE LENNY", value: "LOOSE_EYE_LENNY" },
       { text: "LOUIE ST. LOUIS", value: "LOUIE_ST_LOUIS" },
       { text: "NO NECK NICK", value: "NO_NECK_NICK" },
       { text: "PENCIL TOP", value: "PENCIL_TOP" }
      ],
      selectedMatch: ''
      }
    },
    async created() {
        await this.$http.get('/suspects').then(response => {
           this.suspects = response.data;
           console.log(this.suspects);
        }).catch(e => {
          this.errors.push(e)
          console.log(this.errors)
          this.suspects = this.suspectsLocal
        })
    },
    methods: {
      clearSelections: function () {
        this.selectedSuspects = []
        this.results = []

      },
      matchSuspects: function () {
          const data = { "suspects": this.selectedSuspects, "matches" : this.selectedMatch}
          this.$http.post('/play', data).then(response => {
            this.results = response.data
            console.log(this.results.length )
        }).catch(e => {
          this.errors.push(e)
          console.log("Errors: " + this.errors)
        })
      }
  }
}
</script>