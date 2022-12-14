<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        body {
            background: #8897c4 url(images/Background.jpg); /* Цвет фона и путь к файлу */
            color: #1d2f50; /* Цвет текста */
        }
    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<a href="game-servlet">Game</a>

<div class="container text-center">
    <div class="row">
        <div class="col">
            <div class="card text-bg-warning mb-3" style="max-width: 18rem;">
                <div class="card-header">Characters in this Location</div>
                <div class="card-body">
                    <h5 class="card-title">You can interact with this people</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item text-bg-warning">Элемент</li>
                        <li class="list-group-item text-bg-warning">Второй элемент</li>
                        <li class="list-group-item text-bg-warning">Третий элемент</li>
                    </ul>
                </div>
                <div class="card-body">
                    <h5 class="card-title">You can interact with this people</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item text-bg-warning">Элемент</li>
                        <li class="list-group-item text-bg-warning">Второй элемент</li>
                        <li class="list-group-item text-bg-warning">Третий элемент</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <p class="fs-1">${location.getNameOfLocation()}</p>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#staticBackdrop">
                        Map Of This World
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
                         tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Map</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <img src="/locationImages/imageOfMap.png" class="img-fluid"/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="card">
                <div class="card-body">
                    ${location.getLocationImage()}
                </div>
            </div>
        </div>
        <div class="col">
            HealthBar
            <div class="progress">
                <div class="progress-bar bg-danger" role="progressbar" style="width: ${hero.getCurrentHealth()}%"
                    aria-label="Базовый пример" aria-valuenow="25" aria-valuemin="0" aria-valuemax="${hero.getMaxHealth()}">
                </div>
            </div>
            <br>
            <div class="card text-bg-warning mb-3" style="max-width: 18rem;">
                <div class="card-header"> items</div>
                <div class="card-body">
                    <h5 class="card-title">You see these items in this location</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item text-bg-warning">Элемент</li>
                        <li class="list-group-item text-bg-warning">Второй элемент</li>
                        <li class="list-group-item text-bg-warning">Третий элемент</li>
                    </ul>
                </div>
        </div>
    </div>
</div>
<div class="col-md-6 offset-md-3">
</div>
<br>
</div>
<div class="row">
    <div class="col-md-8 offset-md-2">
        <div class="card">
            <div class="card-body">
                {Decide Space}
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>