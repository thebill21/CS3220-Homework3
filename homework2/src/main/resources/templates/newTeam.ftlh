<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Team</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://bootswatch.com/5/sketchy/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Add New Team</h1>
    <form action="/teams/add" method="post" class="mt-4">
        <div class="mb-3">
            <label for="uniformColow" class="form-label">Uniform Color:</label>
            <select id='uniformColor' name="uniformColor" class="form-select" required>
                <option value="Red">Red</option>
                <option value="Green">Green</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Teal">Teal</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Gender:</label>
            <div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="Male" required>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="Female" required>
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
        </div>

        <div class="mb-3">
            <label for="minAge" class="form-label">Min Age:</label>
            <select id='minAge' name="minAge" class="form-select" required>
                <#list 4..12 as age>
                    <option value="${age}">${age}</option>
                </#list>
            </select>
        </div>

        <div class="mb-3">
            <label for="maxAge" class="form-label">Max Age:</label>
            <select id='maxAge' name="maxAge" class="form-select" required>
                <#list 4..12 as age>
                    <option value="${age}">${age}</option>
                </#list>
            </select>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Add Team</button>
            <a class="btn btn-secondary" href="/teams">Cancel</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<footer class="container mt-4">
    <div class="text-center">
        Hurricanes Soccer Academy - Serving Claremont and Surrounding Area
    </div>
</footer>
</body>
</html>
