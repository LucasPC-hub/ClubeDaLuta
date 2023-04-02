import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CadastroView from "@/views/CadastroView.vue";
import listaView from "@/views/listaView.vue";
import login from "@/components/login.vue";
import loginView from "@/views/loginView.vue";
import {auth} from "@/store/auth";
import listaPView from "@/views/ListaPView.vue";
import criarPartidaView from "@/views/criarPartidaView.vue";
import minhasPartidas from "@/components/minhasPartidas.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path:'/cadastro',
      name:'cadastro',
      component: CadastroView
    },
    {
      path:'/listaUsuarios',
      name:'listaUsuarios',
      component: listaView,
    },
    {
      path:'/login',
      name:'login',
      component: loginView
    },
    {
      path: '/listaPartidas',
      name: 'listaPartidas',
      component: listaPView
    },
    {
      path:'/criarPartidas',
      name: "criarPartidas",
      component: criarPartidaView
    },{
      path:'/minhasPartidas',
      name: "minhasPartidas",
      component: minhasPartidas
    }
  ]
})

export default router
