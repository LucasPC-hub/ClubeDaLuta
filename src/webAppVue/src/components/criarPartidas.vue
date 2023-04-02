<template>

  <div class="text-white mt-3 mask-custom corpo">
    <div class="container">
      <h2 class="text-center">Criar Partida</h2>
      <form>
        <div class="mt-5">
          <label for="data">Data da partida    </label>
          <br>
          <input type="date" v-model="date" id="data" placeholder="Data" name="data" min="01-04-2023">
        </div>
        <div>
          <label for="hora">Hora</label>
          <select class="form-select rounded-pill text-white" v-model="hora" id="hora" name="hora">
            <option value="">Selecione</option>
            <option value="08:00">08:00</option>
            <option value="08:30">08:30</option>
            <option value="09:00">09:00</option>
            <option value="09:30">09:30</option>
            <option value="10:00">10:00</option>
            <option value="10:30">10:30</option>
            <option value="11:00">11:00</option>
            <option value="11:30">11:30</option>
            <option value="12:00">12:00</option>
            <option value="12:30">12:30</option>
            <option value="13:00">13:00</option>
            <option value="13:30">13:30</option>
            <option value="14:00">14:00</option>
            <option value="14:30">14:30</option>
            <option value="15:00">15:00</option>
            <option value="15:30">15:30</option>
            <option value="16:00">16:00</option>
            <option value="16:30">16:30</option>
            <option value="17:00">17:00</option>
            <option value="17:30">17:30</option>
            <option value="18:00">18:00</option>
            <option value="18:30">18:30</option>
            <option value="19:00">19:00</option>
            <option value="19:30">19:30</option>
            <option value="20:00">20:00</option>
            <option value="20:30">20:30</option>
            <option value="21:00">21:00</option>
          </select>
        </div>
        <label class="mt-3" for="participante1">Participante 1</label>
        <select class="form-select rounded-pill text-white"  id="participante1" v-model="participantes[0]"  name="participante1">
          <option value="" disabled selected hidden>Selecione o participante</option>
          <option  v-bind:value="user" v-for="user in users" :key="user.id">{{user.familia}}</option>
        </select>

        <label class="mt-3" for="participante2">Participante 2</label>
        <select class="form-select rounded-pill text-white" v-model="participantes[1]"  id="participante2" name="participante2">
          <option value="" disabled selected hidden>Selecione o participante</option>
          <option  v-bind:value="user" v-for="user in users" :key="user.id">{{user.familia}}</option>
        </select>
        <div class="mt-3 text-center">    <button type="button" @click="criarPartida()" class="px-4 py-2">
          Finalizar Criação
        </button></div>

      </form>
    </div>

  </div>
</template>

<script>

import {criarPartida, getAllUsers} from "@/services/Services";

export default {
  name: "criarPartidas",
  data() {
    return {
      date: '',
      hora: '',
      participantes: [],
      users:[],
    }
  },
  methods: {
    getAllUsers() {
      getAllUsers().then(response => {
        let list = []
        response.forEach(usuario =>{
              if (!usuario.adm){
                list.push(usuario)
              }
        }
        )
        console.log(list)
        this.users = list
      })
    },
      criarPartida(){
        if (this.participantes[0]===this.participantes[1]){
          alert("Não é possível criar uma partida com 2 jogadores iguais")
        }else {
          const payload = {
            data: this.date,
            hora: this.hora,
            participantes: this.participantes
          }
          criarPartida(payload).then(()=>{
            alert("Partida Criada")
            window.location.reload()
          })
        }
      }
  },
  mounted () {
    this.getAllUsers();
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