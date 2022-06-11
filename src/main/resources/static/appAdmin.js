fetch("http://localhost:8080/api")
    .then(res => { res.json().then(
        user=>{
            let navbarDark = ""
            navbarDark += "<b class=\"text-white\" style=\"font-size: 18px\">"+user.username+"</b>"
            navbarDark += "<span class=\"text-white\"  style=\"font-size: 18px\"> &nbsp with roles: &nbsp </span>"
            navbarDark += "<span class=\"text-white\"  style=\"font-size: 18px\">"
            user.roles.forEach((role) => navbarDark += role.role.replace('ROLE_','')+' ')
            navbarDark += "</span>"
            document.getElementById("navbarDark").innerHTML = navbarDark
        }
    )})

fetch('http://localhost:8080/api/admin')
    .then(response => response.json())
    .then(data => showTable(data))

let table = ""
const showTable = (users) => {   //admin
    users.forEach((user) => {
        table += `
                <tr id="${user.id}">
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.surname}</td>
                    <td>${user.age}</td>
                    <td>${user.password}</td>
                    <td>`

        user.roles.forEach((role) => table += role.role.replace('ROLE_', '') + " ")
        table += `
                    </td>
                    <td><button class="btn btn-info eBtn" data-toggle="modal">Edit</button></td>
                    <td><button class="btn btn-danger dBtn" data-toggle="modal">Delete</button></td>
                 `
    })
    document.getElementById("tableAllUsers").innerHTML = table
}

const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) {
            handler(e)
        }
    })
}


// модалка Edit

on(document, 'click', '.eBtn', e => {

    const line = e.target.parentNode.parentNode
    const idMod = line.children[0].innerHTML
    const nameMod = line.children[1].innerHTML
    const surnameMod = line.children[2].innerHTML
    const ageMod = line.children[3].innerHTML
    const passMod = line.children[4].innerHTML
    const rolesMod = line.children[5].innerHTML


    Id.value = idMod
    Name.value = nameMod
    Surname.value = surnameMod
    ageEdit.value = ageMod
    passEdit.value = passMod
    rolesEdit.value = rolesMod
    $('#editModal').modal()
})

editModal.addEventListener('submit', (e) => {
    e.preventDefault()
    let id = 0
    let rolesListEdit = [];
    for (let i = 0; i < $('#rolesEdit').val().length; i++) {
        if ($('#rolesEdit').val()[i] === 'ROLE_ADMIN') {
            id = 1
        } else {
            id = 2
        }
        rolesListEdit[i] = {id: id, role: $('#rolesEdit').val()[i]};
    }

    let editUser = {
        id: Id.value,
        username: Name.value,
        surname: Surname.value,
        age: ageEdit.value,
        password: passEdit.value,
        roles: rolesListEdit

    }
    fetch('http://localhost:8080/api/admin/' + Id.value, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(editUser)
    })
        .then(response => response.json())
        .then(data => {
            const editUserInTable = []
            editUserInTable.push(data)
            showTable(editUserInTable)
        })
        .then(() => document.getElementById(Id.value).remove())
        .then(() => document.getElementById('editModal').click())

})


// модалка Delete

on(document, 'click', '.dBtn', e => {

    const line = e.target.parentNode.parentNode
    const idDelMod = line.children[0].innerHTML
    const usernameDelMod = line.children[1].innerHTML
    const surNameDelMod = line.children[2].innerHTML
    const emailDelMod = line.children[3].innerHTML

    idDel.value = idDelMod
    usernameDel.value = usernameDelMod
    surnameDel.value = surNameDelMod
    emailDel.value = emailDelMod

    $('#deleteModal').modal()
})

deleteModal.addEventListener('submit', (e) => {
    e.preventDefault()
    fetch('http://localhost:8080/api/admin/' + idDel.value, {
        method: 'DELETE'
    })
        .then(() => document.getElementById(idDel.value).remove())
        .then(() => document.getElementById('deleteModalClose').click())
})


// панель добавления юзера

addNewUser.addEventListener('submit', (e) => {
    e.preventDefault()
    let id = 0
    let rolesList = [];
    for (let i = 0; i < $('#roles').val().length; i++) {
        if ($('#roles').val()[i] === 'ROLE_ADMIN') {
            id = 1
        } else {
            id = 2
        }
        rolesList[i] = {id: id, role: $('#roles').val()[i]};
    }
    let newUser = {
        username: usernameNew.value,
        surname: surnameNew.value,
        age: ageNew.value,
        password: passNew.value,
        roles: rolesList
    }

    fetch('http://localhost:8080/api/admin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newUser)
    })
        .then(response => response.json())
        .then((data) => {
            const newUserInTable = []
            newUserInTable.push(data)
            showTable(newUserInTable)
        })
        .then(() => document.getElementById('userTable').click())
})



