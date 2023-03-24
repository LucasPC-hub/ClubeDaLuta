<template>
  <div>
    <div v-if="estaLogado">
      <lista-usuarios></lista-usuarios>
    </div>
    <h1 v-else>Voce Precisa Estar Logado</h1>
  </div>

</template>

<script>
import ListaUsuarios from "@/components/ListaUsuarios.vue";

export default {

  name: "listaView",
  components: {ListaUsuarios},
  computed: {

  }
}
</script>

<style scoped>

</style>