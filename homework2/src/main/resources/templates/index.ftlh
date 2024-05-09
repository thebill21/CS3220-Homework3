<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Hurricanes Soccer Academy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"/>
    <link rel="stylesheet" href="https://bootswatch.com/5/sketchy/bootstrap.min.css"/>
</head>

<body>
<div class="container mt-4">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">
                    <i class="bi bi-globe d-inline" style="font-size: 1em">
                        Hurricanes Soccer Academy
                    </i>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/players">Players</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/teams">Teams</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container">
    <div class="container mt-4">
        <div class="row">
            <h2>Welcome to Hurricanes Soccer Academy</h2>
            <p>
                Teaching advanced skills in a fun environment. Building confidence
                in players of all levels.
            </p>
        </div>
        <div class="row">
            <!-- Column for images -->
            <div class="col-lg-3 col-md-3">
                <img
                        src="https://cs3.calstatela.edu/~csun/soccergirl.jpg"
                        class="img-fluid d-none d-sm-none d-md-block"
                        alt="Soccer Girl"
                />
                <img
                        src="https://cs3.calstatela.edu/~csun/soccerboy.jpg"
                        class="img-fluid d-none d-sm-none d-md-block"
                        alt="Soccer Boy"
                />
            </div>
            <!-- Column for announcements -->
            <div class="col-lg-9 col-md-9">
                <div class="border rounded-1 border-dark border-2 p-2 mb-2 bg-warning">
                    No Practice Today due to rain and poor field conditions, Tuesday,
                    2-6-24
                </div>
                <div class="border rounded-1 border-dark border-2 p-2 mb-2 bg-warning">
                    <a href="#">W23-24 Groupings/Game Schedules</a>
                </div>
                <div class="border rounded-1 border-dark border-2 p-2 mb-2 bg-warning">
                    <a href="#">W23-24 Practice Schedules</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

<footer class="container mt-4">
    <div class="col-lg-12 col-md-12 col-sm-12 text-center">
        Hurricanes Soccer Academy - Serving Claremont and Surrounding Area
    </div>
</footer>
</html>
