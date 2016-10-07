<%@ include file="/view/common/taglib.jsp" %>
<div id="content" style="width: 75%; margin: 0 auto;">
    <div class="woocommerce">
        <h2 class="text-center">SIGN IN</h2>
        <div class="signup_message"></div>
        <div class="signup_action col-md-11">
                <div class="col-md-6">
                    <form method="post" class="login" id="register_form" action='<c:url value="/register.html" />'>
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
                            <input class="input-text" type="password" name="password" id="password" required/>
                        </p>
                        <p class="form-row form-row-wide">
                            <label for="confirmPassword">Confirm Password <span class="required">*</span></label>
                            <input class="input-text" type="password" name="confirmPassword" id="confirmPassword" required/>
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
                    <a data-gaq-event="Header~$~Sign_in~$~login_google" class="signup-g"
                       href="/customer/account/googlesignin/callback/">
                        <small></small>
                        <span>sign up with google</span></a>
                    <a data-gaq-event="Header~$~Sign_in~$~login_facebook"
                       class="signup-fb" href="/customer/account/fbsignin/">
                        <small></small>
                        <span>sign up with facebook</span></a>
                </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
