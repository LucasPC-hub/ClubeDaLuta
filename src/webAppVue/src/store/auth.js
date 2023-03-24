const usuario = JSON.parse(localStorage.getItem('user'));

const state = usuario ? { estaLogado: true, usuario } : { estaLogado: false, usuario: null };

const actions = {
    login({ commit }, usuario) {
        commit('login', usuario);
    },
    logout({ commit }) {
        commit('logout');
    }
};

const mutations = {
    setUsuarioLogado(state, usuario) {
        state.estaLogado = true;
        state.usuario = usuario;
        localStorage.setItem('user', JSON.stringify(usuario));
    },
    logout(state) {
        state.estaLogado = false;
        state.usuario = null;
        localStorage.removeItem('user');
    }
};

const getters = {
    estaLogado: state => state.estaLogado,
    usuario: state => state.usuario
};

export const auth = {
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};
