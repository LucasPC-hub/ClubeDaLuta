import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CadastroView from "@/views/CadastroView.vue";
import listaView from "@/views/listaView.vue";
import login from "@/components/login.vue";
import loginView from "@/views/loginView.vue";
import {auth} from "@/store/auth";


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
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
