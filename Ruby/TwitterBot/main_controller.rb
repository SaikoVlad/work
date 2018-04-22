require 'capybara'
require 'haikunator'

class MainController

  def visit_twitter
    session = Capybara::Session.new :selenium
    text = Haikunator.haikunate(100).slice(0,10)
    # sign_in(session)
    auth_with_twitter session
    # text_filling session, text
  end

  private

  def sign_in(session)
    login = "fakefakefakesss"
    password = "ljgkhf2010596"
    session.visit "https://twitter.com/login/error?redirect_after_login=%2Fregistration"
    # session.find('input[name=session[username_or_email]]').set(login)
    # session.find('input[name=session[username_or_email]]', :with=>login)
    wait_until(timeout=15) do
      session.fill_in("input[class=js-username-field email-input js-initial-focus]", :with=> login)
    end
    session.fill_in 'session[password]', :with=>password
  end


  def text_filling(session, text)
    session.visit("https://twitter.com")
    session.fill_in("tweet-box-home-timeline")
    session.find("tweet-action EdgeButton EdgeButton--primary js-tweet-btn").click
  end


end
m = MainController.new
m.visit_twitter