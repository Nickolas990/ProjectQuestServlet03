<%--
  Created by IntelliJ IDEA.
  User: hrom_
  Date: 08.09.2022
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Game for JR</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<div class="container text-center">
    <div class="row">
        <div class="col">
            <div class="card text-bg-warning mb-3" style="max-width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">You can interact with this people</h5>
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${location.getCharacterInLocation()}" var="character">
                            <li class="list-group-item text-bg-warning">
                                <div class="card">
                                    <h3 id="questGiver">${character}</h3>
                                    <br>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal">
                                        Chat
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1"
                                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div id="content">
                                                        <p>Sorry, I can't hear you. Come closer.
                                                        <p>
                                                            <button onclick='startDialog("${character.getName()}")'
                                                                    class="btn btn-success">Come to Stranger
                                                            </button>
                                                    </div>
                                                    <!--   <form action="quest" method="get">
                                                        <div>
                                                            <input type="hidden" name="character" value=${character}><br>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <div class="button">
                                                                <button type="submit" id="load_btn" class="btn btn-success">Go</button>
                                                            </div>
                                                        </div>
                                                    </form> -->
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#Modal">
                                        Attack
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="Modal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                         aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="ModalLabel">Modal title</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    ...
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Close
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <br>
            </div>
            <div class="card text-bg-secondary mb-3" style="max-width: 18rem;">
                <div class="card-header">Navigation</div>
                <div class="card-body">
                    <h5 class="card-title">Where should I go?</h5>
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${location.getConnectedLocations()}" var="destination">
                            <li class="list-group-item text-bg-secondary">
                                <form action="${pageContext.request.contextPath}/move" method="post">
                                    <input type="hidden" name="destination" value="${destination}">
                                    <button class="btn btn-primary" type="submit">${destination}</button>
                                </form>
                                <br>
                            </li>
                        </c:forEach>
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
                <div class="card-body bs-green" style="max-width: 900px">
                    ${location.getLocationImage()}
                </div>
            </div>
        </div>
        <div class="col">
            HealthBar
            <div class="progress">
                <div class="progress-bar bg-danger" role="progressbar" style="width: ${hero.getCurrentHealth()}%"
                     aria-label="Базовый пример" aria-valuenow="25" aria-valuemin="0"
                     aria-valuemax="${hero.getMaxHealth()}">
                </div>
            </div>
            <br>
            <div class="card">
                <h3>${hero.getName()}</h3>
                <p>Level - ${hero.getLevel()}</p>
                <p>Strength - ${hero.getStrength()}</p>
                <p>Stamina - ${hero.getStamina()}</p>
                <p>Defence - ${hero.getDefence()}</p>
            </div>
            <br>
            <div class="card text-bg-warning mb-3" style="max-width: 18rem;">
                <div class="card-header"> items</div>
                <div class="card-body">
                    <h5 class="card-title">You see these items in this location</h5>
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${location.getItemsInLocation()}" var="item">
                            <li class="list-group-item text-bg-warning">
                                <div class="card">
                                    <h3>${item}</h3>
                                    <br>
                                    <!-- Button trigger modal -->
                                    <form action="${pageContext.request.contextPath}/take" method = post>
                                        <button type="button" class="btn btn-success">
                                            Take
                                        </button>
                                    </form>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#Inspected">
                                        Inspect
                                    </button>
                                    <div class="modal fade" id="Inspected" tabindex="-1" aria-labelledby="exampleModalLabel"
                                         aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="InspectLabel">Modal title</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    ${item.getImage()}
                                                    <p>${item.getName()}</p>
                                                    <p>Damage - ${item.getDamage()}</p>
                                                    <p>Weight - ${item.getWeight()}</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Close
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
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
        {Action}
    </div>
</div>
</body>
</html>