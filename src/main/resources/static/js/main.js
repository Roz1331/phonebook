
let iii;

$(document).ready(function () {

    $("#new-member").click(function (){
        $("#add-member").css("visibility", "visible");
    })

    $("#cancel-btn").click(function (){
        hideForm()
    })

    $("#add-member-btn").click(function () {
        let name = $("#new-name").val()
        let phoneNumber = $("#phone-number").val()

        $.get('/add', {name: name, phoneNumber: phoneNumber}, function () {
            console.log("ok")
            displayLatestMember()
            hideForm()
        })
    })

    function hideForm() {
        $("#new-name").val("")
        $("#phone-number").val("")
        $("#add-member").css("visibility", "hidden");
    }

    function displayLatestMember() {
        $.get('updateTable', function (data) {

            console.log("update table ok")
            console.log(data)

            let newRow = "<tr th:id=\"" + data.id + "\">" +
                "<td> "+ data.id + "</td>" +
                "<td> "+ data.name + "</td>" +
                "<td> "+ data.phoneNumber + "</td>" +
                "<td> "+ data.date + "</td>" +
                "<td class=\"editBtn\"> edit</td>" +
                "<td class=\"delBtn\"> x</td>" +
                "</tr>"
            let tableBody = $("table tbody");
            tableBody.append(newRow);
        })
    }

    $(".editBtn").click(function () {
        let id = $(this).parent().attr("id")
        console.log(id)
        iii = id
        $("#open-modal").click()
    })

    $(".delBtn").click(function () {
        let id = $(this).parent().attr("id")
        console.log("delete method for " + id)
        $.get('delete', {id: id}, function () {
            $('tr#' + id).remove();
            console.log("row deleted")
        })
    })

    $(".update-member").click(function () {
        let name = $("#edit-name").val()
        let phoneNumber = $("#edit-phone").val()
        // console.log(name)
        // console.log(phoneNumber)

        let children = $("tr#" + iii).children()

        $.get('updateMember', {id : iii, name: name, phoneNumber: phoneNumber}, function (data) {
            console.log(data)
            children[1].innerHTML = name
            children[2].innerHTML = phoneNumber
            children[3].innerHTML = data.date
        })

        $("#edit-name").val("")
        $("#edit-phone").val("")
        $('#exampleModal').modal('hide')

        // console.log(children)

    })

});