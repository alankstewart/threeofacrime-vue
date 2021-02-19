<template>
<div class="container">
    <h1>Three Of A Crime</h1>
    <div id="suspects" role="group">
    <b-form-group label="Suspects">
          <b-form-checkbox-group
            size="sm"
            id="suspects"
            v-model="selectedSuspected"
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
    <button id="submit" type="button" class="btn btn-primary" disabled>Match Suspects</button>
    <button id="clear" type="button" class="btn btn-success" v-on:click="clearSelections">Clear Selections</button>
    <button id="startNewGame" type="button" class="btn btn-warning">Start New Game</button>
    <br>
    <br>
    <div class="card text-white bg-info">
        <div class="card-header">Possible Suspect Cards</div>
        <div class="card-body">
            <div id="results"></div>
        </div>
    </div>
    <div id="fifty-fifty" class="alert alert-warning" hidden>
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
//import axios from 'axios';

export default {
  name: 'ThreeOfACrime',
  data() {
    return {
      selectedSuspected: [],
      suspects: [],
//      suspects: [
//        { text: "HUMPTY BUMPTY", value: "1" },
//        { text: "JONNY CORTEX", value: "2" },
//        { text: "KID CASSIDY", value: "3" },
//        { text: "LOOSE-EYE LENNY", value: "4" },
//        { text: "LOUIE ST. LOUIS", value: "5" },
//        { text: "NO NECK NICK", value: "6" },
//        { text: "PENCIL TOP", value: "7" }
//       ],
        selectedMatch: ''
      }
    },
    created() {
        this.$http.get("/suspects").then(response => {
           this.suspects = response.data;
           console.log(this.suspects);
        })
      },
  methods: {
      clearSelections: function () {
        this.selectedSuspected = [];
      }
  }
}
</script>