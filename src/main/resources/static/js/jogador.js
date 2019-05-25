$(document).ready(function () {

    $('#tableJogador').DataTable();

    $("#formCadastroJogador").submit(function (event) {

        event.preventDefault();
        var jogador = { "nome" : $("#nomeJogador").val(),
            "email" : $("#emailJogador").val(),
            "telefone": $("#telefoneJogador").val(),
            "grupo":$("input[name='grupo']:checked").val()};

        if($("#nomeJogador").val() != "" &&
            $("#emailJogador").val() != "" &&
                nomeJogador.checkValidity() &&
                    emailJogador.checkValidity() &&
                        telefoneJogador.checkValidity()){

            document.getElementById("btnOk").disabled = true;
            document.getElementById("btnCancel").disabled = true;

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/salvar",
                data: JSON.stringify(jogador),
                cache: false,
                timeout: 600000,
                success: function (result) {
                    $.notify(result.toString(), {
                        className:'success',
                        clickToHide: false,
                        autoHide: true,
                        timeout:2000,
                        globalPosition: 'top center'
                    });
                    setTimeout(function(){
                        location.href="/jogadores"
                    }, 2000);

                },
                error: function(result) {
                    $.notify(result.responseText, {
                        className:'error',
                        clickToHide: false,
                        autoHide: true,
                        timeout:3000,
                        globalPosition: 'top center'
                    });
                    setTimeout(function(){
                        location.href="/jogadores"
                    }, 3000);
                }
            })
        }


    });

});

