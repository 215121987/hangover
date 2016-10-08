<%@ include file="/view/common/taglib.jsp" %>
<div id="content" style="width: 75%; margin: 0 auto;">
    <div class="woocommerce">
        <h2 class="text-center">SIGN IN</h2>
        <div class="signup_message"></div>
        <div class="signup_action col-md-11">
                <div class="col-md-6">
                    <form method="post" class="user" id="register_form" action='<c:url value="/register.html" />'>
                        <p class="form-row form-row-wide">
                            <label for="name">Name <span class="required">*</span></label>
                            <input class="input-text" type="text" name="name" id="name" required/>
                        </p>
                        <p class="form-row form-row-wide">
                            <label for="mobile">Mobile Number <span class="required">*</span></label>
                            <input class="input-text" type="tel" name="mobile" maxlength="10" id="mobile" required/>
                        </p>
                        <p class="form-row form-row-wide">
                            <label for="email">Email<%--<span class="">*</span>--%></label>
                            <input class="input-text" type="email" name="email" id="email"/>
                        </p>

                        <p class="form-row form-row-wide">
                            <label for="password">Password <span class="required">*</span></label>
                            <input class="input-text" type="password" name="password" pattern="^(?=.*\d)(?=.*[A-Za-z])[A-Za-z0-9]{6,18}$" id="password" required/>
                        </p>
                        <p class="form-row form-row-wide">
                            <label for="confirmPassword">Confirm Password <span class="required">*</span></label>
                            <input class="input-text" type="password" name="confirmPassword" id="confirmPassword" pattern="^(?=.*\d)(?=.*[A-Za-z])[A-Za-z0-9]{6,18}$" required/>
                        </p>
                        <p class="form-row form-row-wide">
                            <label for="confirmPassword">Date of Birth <span class="required">*</span></label>
                            <input type="text" class="input-text" name="dob" id="dob" required="true" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}"/>
                        </p>
                        <p class="form-row form-row-wide">
                            <input  type="checkbox" name="TCConfirm" id="TCConfirm" required/>
                            <label for="TCConfirm">Agree to T&C</label>
                        </p>
                        <p class="form-row">
                            <input type="submit" class="button" name="signUp" value="Sign Up"/>

                        </p>
                    </form>
                </div>
                            <span class="col-separator">
                                  OR
                            </span>
                <div class="col-sm-4 signup_other">
                    <a  class="signup-g"  href="#">
                        <small></small>
                        <span>sign up with google</span></a>
                    <a  class="signup-fb" href="#">
                        <small></small>
                        <span>sign up with facebook</span></a>
                </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
