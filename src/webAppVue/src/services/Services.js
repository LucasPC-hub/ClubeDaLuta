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