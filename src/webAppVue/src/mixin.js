import {mapGetters, mapMutations} from 'vuex'

export const vMixin = {
    computed: {
        ...mapGetters('auth', ['estaLogado', 'usuario'])
    },methods:{
        ...mapMutations('auth', ['setUsuarioLogado','logout']),
    }
}