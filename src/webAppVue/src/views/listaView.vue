<template>
  <div>
    <div v-if="isAdm">
      <lista-usuarios></lista-usuarios>
    </div>
    <h1 class="text-light align-content-center" v-else>Acesso Restrito</h1>
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