<template>
  <nav class="navbar navbar-dark navbar-expand-lg bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Clube da Luta</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link to="/" class="nav-link active" aria-current="page">Home</router-link>
          </li>
          <li  class=" nav-item">
            <router-link class="nav-link" to="listaPartidas" href="#">Lista de Partidas</router-link>
          </li>
          <li v-if="estaLogado" class=" nav-item">
            <router-link class="nav-link" to="minhasPartidas" href="#">Minhas Partidas</router-link>
          </li>
          <li v-if="isAdm" class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Opcões Adm
            </a>
            <ul class="dropdown-menu">
              <li><router-link v-if="isAdm" class="dropdown-item" to="listaUsuarios" href="#">Lista de Usuarios</router-link></li>
              <li><router-link v-if="isAdm" to="criarPartidas" class="dropdown-item" href="#">Criar Partidas</router-link></li>
            </ul>
          </li>
        </ul>

      </div>
      <a v-if="estaLogado" class="navbar-brand" href="#">Olá, {{ usuario.familia }}!</a>
      <button>
      <router-link v-if="!estaLogado" class="nav-link" to="login" href="#">Login</router-link>
        <a v-else @click="logout">Logout</a>
    </button>

    </div>
  </nav>
</template>

<script>


export default {
  name: "navBar"
}
</script>

<style scoped>

</style>