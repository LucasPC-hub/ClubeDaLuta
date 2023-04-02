<template>
  <div >
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center  align-items-center h-100">
        <div class="col-md-12 col-xl-10">

          <div class="card mask-custom">
            <div class="card-body p-4 text-white">

              <div class="text-center pt-3 pb-2">
                <h2 class="my-4">Usuarios</h2>
              </div>

              <table class="table text-white mb-0">
                <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Nome de familia</th>
                  <th scope="col">Classe</th>
                  <th scope="col">Email</th>
                  <th scope="col">Discord</th>
                  <th v-if="isAdm" scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="user in users" :key="user.id">
                  <td>
                    <h6 class="ms-2">{{ user.id }}</h6>
                  </td>
                  <td class="align-middle">
                    <h6>{{user.familia}}</h6>
                  </td>
                  <td class="align-middle">
                    <h6>{{user.classe}}</h6>
                  </td>
                  <td class="align-middle">
                    <h6 class="mb-0">{{user.email}}</h6>
                  </td>
                  <td class="align-middle">
                    <h6>{{user.discord}}</h6>
                  </td>
                  <td v-if="isAdm">
                    <button @click="excludeUser(user.id)"> Excluir Usuario</button>
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

import {excludeUser, getAllUsers} from "@/services/Services";

export default {
  name: 'ListaUsuarios',
  data() {
    return {
      users: []
    }
  },
  methods: {
    getAllUsers() {
      getAllUsers().then(response => {
        this.users = response
      })
    },
    excludeUser(data){
      excludeUser(data).then(response =>{
            alert(response.message);
            window.location.reload();
      }
      )
    }
  },
    mounted () {
      this.getAllUsers();
    }
}
</script>