
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
        $.get('update', function (data) {

            console.log("update table ok")
            console.log(data)

            let newRow = "<tr>" +
                "<td> "+ data.id + "</td>" +
                "<td> "+ data.name + "</td>" +
                "<td> "+ data.phoneNumber + "</td>" +
                "<td> "+ data.date + "</td>" +
                "</tr>"
            let tableBody = $("table tbody");
            tableBody.append(newRow);
        })
    }
});