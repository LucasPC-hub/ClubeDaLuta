<template>
    <div class="container">
        <h2>Users</h2>
        <table class="table text-light table-bordered">
            <thead>
            <tr>
                <th>User Id</th>
                <th>Nome de Familia</th>
                <th>Classe</th>
                <th>Email</th>
                <th>Discord</th>
            </tr>
            </thead>
            <tbody>
              <tr v-for="item in users" :key="item.id">
                  <td>{{ item.id }}</td>
                  <td>{{ item.familia }}</td>
                  <td>{{ item.classe }}</td>
                  <td>{{ item.email }}</td>
                  <td>{{ item.discord }}</td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        name: 'Users',
        props: ['users']
     }
</script>