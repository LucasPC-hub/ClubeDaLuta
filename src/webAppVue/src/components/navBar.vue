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
          <li v-if="isAdm" class=" nav-item">
            <router-link v-if="isAdm" class="nav-link" to="listaUsuarios" href="#">Lista de Usuarios</router-link>
          </li>
<!--          <li class="nav-item">-->
<!--            <a class="nav-link" href="#">Pricing</a>-->
<!--          </li>-->
<!--          <li class="nav-item dropdown">-->
<!--            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<!--              Dropdown link-->
<!--            </a>-->
<!--            <ul class="dropdown-menu">-->
<!--              <li><a class="dropdown-item" href="#">Action</a></li>-->
<!--              <li><a class="dropdown-item" href="#">Another action</a></li>-->
<!--              <li><a class="dropdown-item" href="#">Something else here</a></li>-->
<!--            </ul>-->
<!--          </li>-->
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