import {mapGetters, mapMutations} from 'vuex'

export const vMixin = {
    computed: {
        ...mapGetters('auth', ['estaLogado','usuario','isAdmin'])
    },methods:{
        ...mapMutations('auth', ['setUsuarioLogado','logout']),
    }
}