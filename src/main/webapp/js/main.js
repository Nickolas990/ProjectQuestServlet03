$(function(){
    $("#load_btn").click(function(e){
            $.ajax({
                url: "/quest",
                method: "GET",
                dataType: "jsp",
                data : {
                    character: "Grentias"
                },
                error: function (msg) {
                  console.log(msg);
                  alert('error!')
                },
                success: function(data) {
                    console.log(data)
                    alert('success!');
                    $("#content").html(data)
                }
            })
        })
    });
function startDialog(character) {
    $.ajax({
        url: "/quest",
        method: "GET",
        dataType: "html",
        data: {character: character},
        error: function (msg) {
            console.log(msg);
            alert('error');
        },
        success: function(data) {
            $("#content").html(data)
        }
    })
}
function continueDialog(id) {
    $.ajax({
        url: "/quest",
        method: "GET",
        dataType: "html",
        data: {id: id},
        error: function (msg) {
            console.log(msg);
            alert('error');
        },
        success: function(data) {
            $("#content").html(data)
        }
    })
}