<template>

  <div class="text-white mt-3 mask-custom corpo">
    <div class="container">
      <h2 class="text-center">Cadastrar</h2>
      <form>
        <div class="mb-3 mt-5">
          <input type="email" v-model="email" id="email" placeholder="Email" name="email">
        </div>
        <div class="mb-3">
          <input type="password" v-model="password" id="password" placeholder="Senha" name="password">
        </div>
        <div class="mb-3 mt-3">
          <input type="text"  v-model="familia" id="familia" placeholder="Nome no Jogo" name="familia">
        </div>
        <div class="mb-3 mt-3">
          <input type="text" v-model="discord" id="discord" placeholder="Discord" name="discord">
        </div>
        <select class="form-select rounded-pill text-white" v-model="classe" id="classe" name="classe">
          <option value="" disabled selected hidden>Selecione sua classe</option>
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

        <div class="mt-3 text-center">    <button type="button" @click="createUser()" class="px-4 py-2">
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
button{
  height: 5em;
}
select {
  -webkit-appearance: none; /* remove o estilo padrão do select em navegadores WebKit */
  -moz-appearance: none; /* remove o estilo padrão do select em navegadores Mozilla */
  appearance: none; /* remove o estilo padrão do select */
  background-image: url('../assets/seta-para-baixo.png'); /* define a imagem de seta personalizada */
  background-repeat: no-repeat; /* impede a repetição da imagem */
  background-position: right center; /* define a posição da imagem */
  padding-right: 20px; /* adiciona um espaço para a imagem */
  border: 2px rgba(0, 0, 0, 0.4); /* adiciona uma borda */
  border-radius: 5px; /* adiciona bordas arredondadas */

}

.form-select{
  border-left: 1px solid rgba(255, 255, 255, 0.3);;
  border-top: 1px solid rgba(255, 255, 255, 0.3);;
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);;
  background-color: rgba(0, 0, 0, 0.1);
  padding: 1em;
}
option{
  background-color:rgba(0, 0, 0, 0.8);
}
</style>