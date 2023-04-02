<template>
  <div >
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center  align-items-center h-100">
        <div class="col-md-12 col-xl-10">

          <div class="card mask-custom">
            <div class="card-body p-4 text-white">

              <div class="text-center pt-3 pb-2">
                <img src="../assets/swords.png"
                     alt="Shield With Two Swords In Cross Comments - Shield Symbol @clipartmax.com"                     width="60">
                <h2 class="my-4">Partidas</h2>
              </div>

              <table class="table text-white mb-0">
                <thead>
                <tr>
                  <th scope="col">Horario</th>
                  <th scope="col"></th>
                  <th scope="col">Participantes</th>
                  <th scope="col"></th>
                  <th scope="col">Vencedor</th>
                  <th v-if="isAdm" scope="col"></th>
                  <th v-if="isAdm" scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="partida in partidas" :key="partida.id">
                  <td>
                    <h6 class="ms-2">{{ partida.data }}</h6>
                    <h6 class="ms-2">{{ partida.hora }}</h6>
                  </td>
                  <td class="align-middle">

                    <h6>Classe : {{partida.participantes[0].classe}}</h6>
                    <h6>Nome: {{partida.participantes[0].familia}}  </h6>
                  </td>
                  <td class="align-middle">
                    <h6 class="mb-0">VS</h6>
                  </td>
                  <td class="align-middle">
                    <h6>Classe : {{partida.participantes[1].classe}}</h6>
                    <h6>Nome: {{partida.participantes[1].familia}}  </h6>
                  </td>
                  <td class="align-middle">
                      <p v-if="partida.vencedor !== null">{{ partida.vencedor.familia }}</p>
                      <div v-else-if="isAdm">
                        <button class="align-content-center" @click="selecionarPartida(partida)" > Selecionar Vencedor</button>
                        <transition name="fade">
                          <div class="d-flex flex-row" v-if="partidaSelecionada ===partida">
                            <button @click="selecionarVencedor(partida,partida.participantes[0])" class="vencedores" >{{partida.participantes[0].familia}} </button>
                            <button  @click="selecionarVencedor(partida,partida.participantes[1])" class="vencedores" >{{partida.participantes[1].familia}} </button>
                          </div>
                        </transition></div>
                      <p v-else>Não Disputado</p>
                  </td>
                  <td v-if="isAdm" class="align-middle">
                    <button @click="excludePartida(partida.id)" > Excluir Partida</button>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {excludePartida, getPartidas, selecionarVencedor} from "@/services/Services";

export default {
  name: "listaPartidas",
  data() {
    return {
      partidas: [],
      exibirElemento:false,
      partidaSelecionada: "",
      vencedor:""
    };
  },
  methods: {
    getPartidas() {
      getPartidas().then(response => {
        console.log(response)
        this.partidas = response
      })
    },excludePartida(id){
      excludePartida(id).then(response =>{
        alert(response.message);
        window.location.reload();
      })
    },selecionarPartida(partida) {
      this.partidaSelecionada = partida;
    },selecionarVencedor(partida1,usuario){
      const payload = {
        partida: partida1,
        vencedor: usuario
      }
      selecionarVencedor(payload).then(response =>{
        alert(response.message);
        window.location.reload();
      })
    }
  },
  mounted () {
    this.getPartidas();
  },
};
</script>

<style scoped>

body {
  background-color: rgba(0, 0, 0, 0.8);
}

.form-select{
  border-left: 1px solid rgba(255, 255, 255, 0.3);;
  border-top: 1px solid rgba(255, 255, 255, 0.3);;
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);;
  background-color: rgba(0, 0, 0, 0.5);
  padding: 1em;
}
option{
  background-color:rgba(0, 0, 0, 0.8);
}
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s linear;
}
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
.vencedores{
  padding: 0.5rem;
  width: 8rem;
}
</style>