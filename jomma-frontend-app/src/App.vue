<template>
  <div id="app">
    <InvestStocks/>
  </div>
</template>

<script>

import InvestStocks from "@/components/InvestStocks.vue";

export default {
  name: 'App',
  components: {
    InvestStocks
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
