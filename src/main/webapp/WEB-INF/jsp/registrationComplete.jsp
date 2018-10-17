<!DOCTYPE html>
<html>
    <head>
        <title>lms registration</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/registrationComplete.css">
        <script type="text/javascript" src="/libraryManagementSystem/js/registrationComplete.js"></script>
    </head>
    <body>
        <header>
            <h1>Registration</h1>
            <h2>LMS</h2>
        </header>


        <form name="form" action="/libraryManagementSystem/registrationComplete" method="post" onsubmit="return validate()">

            <div class="table">
                <table>
                    <tr>
                        <td><label>First Name:</label><br><input type="text" name="firstName" value="${requestScope.registration.firstName}" spellcheck="false" readonly="readonly"/></td>
                        <td><label>Last Name:</label><br><input type="text" name="lastName" value="${requestScope.registration.lastName}" spellcheck="false" readonly="readonly"/></td>
                    </tr>

                    <tr>
                        <td><label>Email:</label><br>
                            <input type="text" name="emailAddress" value="${requestScope.registration.emailAddress}" spellcheck="false" readonly="readonly"/></td>
                    </tr>

                    <tr>
                        <td><label>Gender:</label><br>
                            <input type="radio" name="gender" value="male" checked="checked"/><label>Male</label>
                            <input type="radio" name="gender" value="Female"/><label>Female</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><label>Date Of Birth:</label><br>

                            <select name="day" onfocus="validateDateOfBirth()" oninput="validateDateOfBirth()">
                                <option value="">dd</option>
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                                <option value="24">24</option>
                                <option value="25">25</option>
                                <option value="26">26</option>
                                <option value="27">27</option>
                                <option value="28">28</option>
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="31">31</option>
                            </select>

                            <select name="month" onfocus="validateDateOfBirth()" oninput="validateDateOfBirth()">
                                <option value="">mm</option>
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            <select name="year" onfocus="validateDateOfBirth()" oninput="validateDateOfBirth()">
                                <option value="">yyyy</option>
                                <option value="1950">1950</option>
                                <option value="1951">1951</option>
                                <option value="1952">1952</option>
                                <option value="1953">1953</option>
                                <option value="1954">1954</option>
                                <option value="1955">1955</option>
                                <option value="1956">1966</option>
                                <option value="1957">1957</option>
                                <option value="1958">1958</option>
                                <option value="1959">1959</option>
                                <option value="1960">1960</option>
                                <option value="1961">1961</option>
                                <option value="1962">1962</option>
                                <option value="1963">1963</option>
                                <option value="1964">1964</option>
                                <option value="1965">1965</option>
                                <option value="1966">1966</option>
                                <option value="1967">1967</option>
                                <option value="1968">1968</option>
                                <option value="1969">1969</option>
                                <option value="1970">1970</option>
                                <option value="1971">1971</option>
                                <option value="1972">1972</option>
                                <option value="1973">1973</option>
                                <option value="1974">1974</option>
                                <option value="1975">1975</option>
                                <option value="1976">1976</option>
                                <option value="1977">1977</option>
                                <option value="1978">1978</option>
                                <option value="1979">1979</option>
                                <option value="1980">1980</option>
                                <option value="1981">1981</option>
                                <option value="1982">1982</option>
                                <option value="1983">1983</option>
                                <option value="1984">1984</option>
                                <option value="1985">1985</option>
                                <option value="1986">1986</option>
                                <option value="1987">1987</option>
                                <option value="1988">1988</option>
                                <option value="1989">1989</option>
                                <option value="1990">1990</option>
                                <option value="1991">1991</option>
                                <option value="1992">1992</option>
                                <option value="1993">1993</option>
                                <option value="1994">1994</option>
                                <option value="1995">1995</option>
                                <option value="1996">1996</option>
                                <option value="1997">1997</option>
                                <option value="1998">1998</option>
                                <option value="1999">1999</option>
                                <option value="2000">2000</option>
                                <option value="2001">2001</option>
                            </select></td>
                        <td><label id="dateOfBirth"></label></td>
                    </tr>
                    <tr>
                        <td><label>New user ID:</label><br>
                            <input type="text" name="userId" autocomplete="off" maxlength="30" spellcheck="false" onfocus="validateUserId()" oninput="validateUserId()"/></td>
                        <td><label id="userId"></label></td>
                    </tr>
                    <tr>
                        <td><label>New password:</label><br>
                            <input type="password" name="newPassword" onfocus="validateNewPassword()" oninput="validateNewPassword()"/></td>
                        <td><label id="newPassword"></label></td>
                    </tr>
                    <tr>
                        <td><label>Confirm password:</label><br>
                            <input type="password" name="confirmPassword" onfocus="validateConfirmPassword()" oninput="validateConfirmPassword()"/></td>
                        <td><label id="confirmPassword"></label></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Clear"/>&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="submit" value="Complete registration"/></td>
                        <td></td>
                    </tr>

                </table>

            </div>

        </form>

    </body>
</html>