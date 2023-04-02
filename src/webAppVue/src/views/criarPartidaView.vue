<template>
<criar-partidas v-if="isAdm"></criar-partidas>
  <h1 class=" corpo text-light align-content-center" v-else>Acesso Restrito</h1>

</template>

<script>
import criarPartidas from "@/components/criarPartidas.vue";
import CriarPartidas from "@/components/criarPartidas.vue";
export default {
  name: "criarPartidaView",
  components: {CriarPartidas}
}
</script>

<style scoped>

</style>