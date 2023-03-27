import {mapGetters, mapMutations} from 'vuex'

export const vMixin = {
    computed: {
        ...mapGetters('auth', ['estaLogado','usuario','isAdm'])
    },methods:{
        ...mapMutations('auth', ['setUsuarioLogado','setAdmin','logout']),
    }
}