<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Teams</title>
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
                            <a class="nav-link" href="teams">Teams</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container mt-4">
    <h2>Teams</h2>
    <a class="btn btn-secondary" href="/teams/new" style="display:inline-block; margin-bottom:20px;">Add Team</a>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Gender</th>
            <th scope="col">Age Range</th>
            <th scope="col">Uniform Color</th>
            <th scope="col">Players</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list teams as team>
            <tr>
                <td>${team.id}</td>
                <td>${team.gender}</td>
                <td>${team.minAge} - ${team.maxAge}</td>
                <td>${team.uniformColor}</td>
                <td>${team.numberOfPlayers}</td>
                <td>
                    <a href="/teams/${team.id}/roster" class="btn btn-info">View Roster</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
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