import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import "bootstrap/dist/css/bootstrap.css";
import "./assets/style.scss"
import { createStore } from 'vuex'
import {vMixin} from "@/mixin";

const app = createApp(App)
const store = createStore({
    modules: {
        auth
    }
})
app.mixin(vMixin)
app.use(router)
app.use(store)
app.mount('#app')

import "bootstrap/dist/js/bootstrap.js"
import {auth} from "@/store/auth";