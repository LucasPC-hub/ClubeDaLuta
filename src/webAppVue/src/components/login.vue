<template>
  <div class="corpo">
    <form @submit.prevent="login">
      <p class="fs-1">Realizar Login</p>
      <input type="email" placeholder="Email" v-model="email"><br>
      <input type="password" v-model="password" placeholder="Password">
      <br>
      <input type="submit" value="Log in">
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import router from "@/router";
export default {
  name:"login",
  data() {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    async login() {
      try {
        // Faça uma chamada POST para o endpoint de login no backend
        const response = await axios.post('/api/login', {
          email: this.email,
          password: this.password
        });

        // Verifique se a autenticação foi bem sucedida
        if (response.data.sucesso) {
          // A autenticação foi bem sucedida, faça algo com o usuário retornado
          const usuario = response.data.usuario;
          this.setUsuarioLogado(usuario)
          await router.push("/")
        } else {
          // A autenticação falhou, mostre uma mensagem de erro ao usuário
          alert('Nome de usuário ou password inválido.');
        }
      } catch (error) {
        // A chamada HTTP falhou, mostre uma mensagem de erro ao usuário
        alert('Ocorreu um erro ao fazer o login.');
        console.error(error)
      }
    }
  }
}
</script>

<style scoped lang="scss">

$black: rgba(0, 0, 0, 0.4);

.corpo{
  margin-top: 30px;
  width: 800px;
}



</style>