<template>
  <div class="home">
    <Crime/>
  </div>
</template>

<script>
// @ is an alias to /src
import Crime from '@/components/Crime.vue'

export default {
  name: 'ThreeOfACrime',
  components: {
    Crime
  }
}
</script>
