<template>
  <div class="text-white bg-opacity-75 bg-dark  p-5 m-5">
    <div class="row mrgnbtm">
      <Users v-if="users.length > 0" :users="users" />
    </div>
  </div>
</template>

<script>
import Users from './Users.vue'
import { getAllUsers} from "@/services/Services";

export default {
  name: 'ListaUsuarios',
  components: {
    Users
  },
  data() {
    return {
      users: [],
      numberOfUsers: 0
    }
  },
  methods: {
    getAllUsers() {
      getAllUsers().then(response => {
        console.log(response)
        this.users = response
        this.numberOfUsers = this.users.length
      })
    }
  },
    mounted () {
      this.getAllUsers();
    }
}
</script>