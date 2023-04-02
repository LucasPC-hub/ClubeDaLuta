const usuario = JSON.parse(localStorage.getItem('user'));

const state = usuario ? { estaLogado: true, usuario, isAdm: usuario.adm } : { estaLogado: false, usuario: null, isAdmin: false };


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
    setAdmin(state, isAdmin) {
        state.isAdm = isAdmin;
    },
    logout(state) {
        state.estaLogado = false;
        state.usuario = null;
        localStorage.removeItem('user');
        window.location.reload();
    }
};

const getters = {
    estaLogado: state => state.estaLogado,
    usuario: state => state.usuario,
    isAdm: state => state.isAdm
};

export const auth = {
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};
