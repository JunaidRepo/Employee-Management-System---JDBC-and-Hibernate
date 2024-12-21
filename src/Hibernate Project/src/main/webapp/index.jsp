<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
 <c:if test="${not empty successMessage}">
        <p style="color: red;">${successMessage}</p>
    </c:if>
    
    
    <h1>Employee List</h1>
    
    <form action="sort" style="position: absolute; right: 0;">
    <h5>Filter and Sort Data</h5>
    <select name="sorting" onchange="this.form.submit()">
        <option value="" disabled selected>Select an option</option>
        <option value="idasc">ID &uarr;</option>
        <option value="iddesc">ID &darr;</option>
        <option value="nameasc">Name &uarr;</option>
        <option value="namedesc">Name &darr;</option>
        <option value="ageasc">Age &uarr;</option>
        <option value="agedesc">Age &darr;</option>
        <option value="emailasc">Email &uarr;</option>
        <option value="emaildesc">Email &darr;</option>
        <option value="salasc">Salary &uarr;</option>
        <option value="saldesc">Salary &darr;</option>
    </select>
</form>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Salary</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${Employeees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.age}</td>
                    <td>${employee.email}</td>
                    <td>${employee.sal}</td>
                    <td><form action="ud">
                    <button name="upd" value="u ${employee.id}">Update</button>
                    <button name="upd" value="d ${employee.id}">Delete</button>
                </form>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
