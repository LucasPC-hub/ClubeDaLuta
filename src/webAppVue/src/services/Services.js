import axios from "axios";

export async function getAllUsers() {

    const response = await fetch('/api/usuario/lista');
    return await response.json();
}

export async function UserCreate(data) {
    const response = await fetch(`/api/usuario/incluir`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}
export async function criarPartida(data) {
    const response = await fetch(`/api/partida/incluir`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}
export async function getPartidas(){
    const response = await fetch('/api/partidas/lista');
    return await response.json();
}

export async function excludeUser(data) {
    const response = await fetch(`/api/usuario/excluir`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: data
    })
    return await response.json();
}
export async function excludePartida(data) {
    const response = await fetch(`/api/partida/excluir`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: data
    })
    return response.toString()
}
export async function selecionarVencedor(data) {
    const response = await fetch(`/api/partida/incluirVencedor`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}

export async function getHora(date,hora){
    axios.get('https://worldtimeapi.org/api/timezone/America/Sao_Paulo')
        .then((response) => {
            const dateObj = new Date(response.data.datetime);
            const formattedTime = dateObj.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'});
            const formattedDate = dateObj.toLocaleDateString();
            if (date===formattedDate && hora===formattedTime){
                alert("Partida Iniciando")
            }

        })
        .catch((error) => {
            console.log(error);
        });
}