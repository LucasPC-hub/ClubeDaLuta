<template>
  <div >
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center  align-items-center h-100">
        <div class="col-md-12 col-xl-10">

          <div class="card mask-custom">
            <div class="card-body p-4 text-white">

              <div class="text-center pt-3 pb-2">
                <img src="../assets/swords.png"
                     alt="Shield With Two Swords In Cross Comments - Shield Symbol @clipartmax.com"  width="60">
                <h2 class="my-4">Minhas Partidas</h2>
              </div>

              <table class="table text-white mb-0">
                <thead>
                <tr>
                  <th scope="col">Horario</th>
                  <th scope="col"></th>
                  <th scope="col">Participantes</th>
                  <th scope="col"></th>
                  <th scope="col">Vencedor</th>
                </tr>
                </thead>
                <tbody v-for="partida in partidas" :key="partida.id">
                <tr  v-if="partida.participantes[0].id===usuario.id || partida.participantes[1].id===usuario.id">
                  <td>
                    <h6 class="ms-2">{{ partida.data }}</h6>
                    <h6 class="ms-2">{{ partida.hora }}</h6>
                  </td>
                  <td class="align-middle">

                    <h6>Classe : {{partida.participantes[0].classe}}</h6>
                    <h6>Nome : {{partida.participantes[0].familia}}  </h6>
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
                    <p v-else>Não Disputado</p>
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
import { getPartidas} from "@/services/Services";

export default {
  name: "minhasPartidas",
  data() {
    return {
      partidas: []
    };
  },
  methods: {
    getPartidas() {
      getPartidas().then(response => {
        console.log(response)
        this.partidas = response
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

</style>