let arr;

function findAll() {
    $.ajax({
        url: "http://localhost:8081/employee",
        type: "GET",
        success(data) {
            let arr = data
            let context = `<table border="1"><tr>
                            <th>STT</th>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th colspan="3">Action</th>
                            </tr>`
            for (let i = 0; i < arr.length; i++) {
                context += `<tr>
                            <td>${i + 1}</td>
                            <td>${arr[i].code}</td>
                            <td>${arr[i].name}</td>
                            <td>${arr[i].age}</td>
                            <td>${arr[i].salary}</td>
                            <td>${arr[i].department.name}</td>
                            <td><button onclick="updateForm(${arr[i].id})">Update</button></td>
                            <td><button onclick="deleteProduct(${arr[i].id})">Delete</button></td>
                            <td><button onclick="detail(${arr[i].id})">Detail</button></td>
                            </tr>`
            }
            context += `</table>`
            document.getElementById("display").innerHTML = context
            $("#form").hide()
            $("#display").show()
        }
    })
}

function createForm() {
    let content = `<label><select id="category"></label>`
    for (let i = 0; i < arr.length; i++) {
        content += `<option value="${arr[i].id}">${arr[i].name}</option>`
    }
    content += `</select>`
    document.getElementById("cate").innerHTML = content
    $("#name").val("")
    $("#code").val("")
    $("#salary").val("")
    $("#age").val("")
    document.getElementById("title").innerHTML = "Create form"
    $("#form").show()
    document.getElementById("action").setAttribute("onclick", "createProduct()")
    document.getElementById("action").innerHTML = "Create"
    $("#display").hide()
}

window.onload = getCategories

function getCategories() {
    $.ajax({
        url: "http://localhost:8081/department",
        type: "GET",
        success(data) {
            arr = data
        }
    })
}

function createProduct() {
    let product = {
        name: $("#name").val(),
        code: $("#code").val(),
        age: $("#age").val(),
        salary: $("#salary").val(),
        department: {
            id: $("#category").val()
        }
    }
    $.ajax({
        url: "http://localhost:8081/employee",
        type: "POST",
        contentType: "application/json",
        accept: "application/json",
        data: JSON.stringify(product),
        success() {
            findAll()
        }
    })
    event.preventDefault()
}

function updateForm(id) {
    let content = `<label><select id="category"></label>`
    for (let i = 0; i < arr.length; i++) {
        content += `<option value="${arr[i].id}">${arr[i].name}</option>`
    }
    content += `</select>`
    document.getElementById("cate").innerHTML = content
    $.ajax({
        url: `http://localhost:8081/employee/${id}`,
        type: "GET",
        success(data) {
            $("#name").val(data.name)
            $("#code").val(data.code)
            $("#salary").val(data.salary)
            $("#age").val(data.age)
            document.getElementById("title").innerHTML = "Update form"
            $("#form").show()
            document.getElementById("action").setAttribute("onclick", `updateProduct(${id})`)
            document.getElementById("action").innerHTML = "Update"
            $("#display").hide()
        }
    })
}

function updateProduct(id) {
    let product = {
        id: id,
        name: $("#name").val(),
        code: $("#code").val(),
        age: $("#age").val(),
        salary: $("#salary").val(),
        department: {
            id: $("#category").val()
        }
    }
    $.ajax({
        url: "http://localhost:8081/employee/"+id,
        type: "PUT",
        contentType: "application/json",
        accept: "application/json",
        data: JSON.stringify(product),
        success() {
            findAll()
        }
    })
    event.preventDefault()
}

function deleteProduct(id) {
    if (confirm("Có xóa không?")) {
        $.ajax({
            url: "http://localhost:8081/employee/" + id,
            type: "DELETE",
            success() {
                findAll()
            }
        })
    }
}

function backHome() {
    findAll()
    $("#form").hide()
    $("#display").show()
    event.preventDefault()
}

function detail(id) {
    $.ajax({
        url: "http://localhost:8081/employee/"+id,
        type: "GET",
        success(data) {
            let arr = data
            let context = `<table>`
                context += `<tr>
                            <td><label for="">Code</label>${data.code}</td>
                            <td><label for="">Name</label>${data.name}</td>
                            <td><label for="">Age</label>${data.age}</td>
                            <td><label for="">Salary</label>${data.salary}</td>
                            <td><label for="">Department</label>${data.department.name}</td>
                            <td><button onclick="backHome()">Back home</button></td>
                            </tr>`
            context += `</table>`
            document.getElementById("display").innerHTML = context
            $("#form").hide()
            $("#display").show()
        }
    })
}