<template>

  <div class="text-white bg-opacity-75 bg-dark  p-5 m-5">
    <div class="container mt-3">
      <h2 class="text-center">Cadastrar</h2>
      <form>
        <div class="mb-3 mt-3">
          <label for="email">Email:</label>
          <input type="email" class="form-control" v-model="email" id="email" placeholder="Email" name="email">
        </div>
        <div class="mb-3">
          <label for="pwd">Senha:</label>
          <input type="password" class="form-control" v-model="password" id="password" placeholder="Senha" name="password">
        </div>
        <div class="mb-3 mt-3">
          <label for="familia">Nome de Familia:</label>
          <input type="text" class="form-control" v-model="familia" id="familia" placeholder="Nome no Jogo" name="familia">
        </div>
        <div class="mb-3 mt-3">
          <label for="discord">Discord:</label>
          <input type="text" class="form-control" v-model="discord" id="discord" placeholder="Discord" name="discord">
        </div>
        <label for="classe" class="form-label">Selecione a classe: </label>
        <select class="form-select" v-model="classe" id="classe" name="classe">
          <option value="Guerreiro">Guerreiro</option>
          <option value="Valquiria">Valquiria</option>
          <option value="Cacadora">Caçadora</option>
          <option value="Feiticeira">Feiticeira</option>
          <option value="Berserker">Berserker</option>
          <option value="Bruxa">Bruxa</option>
          <option value="Mago">Mago</option>
          <option value="Domadora">Domadora</option>
          <option value="Ninja">Ninja</option>
          <option value="Kunoichi">Kunoichi</option>
          <option value="Musa">Musa</option>
          <option value="Maehwa">Maehwa</option>
          <option value="Lutador">Lutador</option>
          <option value="DK">Cavaleira das Trevas</option>
          <option value="Mistica">Mística</option>
          <option value="Arqueiro">Arqueiro</option>
          <option value="Lahn">Lahn</option>
          <option value="Shai">Shai</option>
          <option value="Guardia">Guardiã</option>
          <option value="Hashashin">Hashashin</option>
          <option value="Nova">Nova</option>
          <option value="Sage">Sage</option>
          <option value="Corsaria">Corsária</option>
        </select>
        <br>

        <div class="text-center">    <button type="button" @click="createUser()" class="px-4 py-2">
          Finalizar Cadastro
        </button></div>

      </form>
    </div>

  </div>
</template>

<script>
import {UserCreate} from "@/services/Services";
import router from "@/router";
export default {
  name: "cadastro",
  data() {
    return {
      email: '',
      password: '',
      familia: '',
      discord: '',
      classe: ''
    }
  },
  methods: {
    createUser() {
      const payload = {
        email: this.email,
        familia: this.familia,
        password: this.password,
        discord: this.discord,
        classe: this.classe
      }
      console.log(payload)
      this.$emit('UserCreate',payload)
      UserCreate(payload).then(()=>{
        alert("Usuario Criado")
        router.push("/")
      })
      }
    }
  }
</script>

<style scoped>

</style>