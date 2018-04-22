require 'capybara'
require 'haikunator'



class Registration

  def get_accounts(param)
    # f = File.new('../../../../Рабочий стол/logruby.txt', 'a')
    # t1 = Time.new
    # f.puts "\n\t\t#{t1.localtime}"
    i = 0
    while i < param.to_i
      # begin
        session = Capybara::Session.new(:selenium)
        log = Haikunator.haikunate(100).slice(0,15)
        pass = Haikunator.haikunate(100).slice(0,15)
        name = Haikunator.haikunate(100).slice(0,10)
        surname = Haikunator.haikunate(100).slice(0,10)
        dev_by_working session, log, pass, name, surname
        mail_working session, log
        puts "#{i + 1}) Log: #{log}\t\tPass: #{pass}"
        # f.puts "#{i + 1}) Log: #{log}\t\tPass: #{pass}"
      # rescue
        puts "Error, user with this name is already exist!"
        # f.puts "Error, user with this name is already exist!"
        i -= 1
      # end
      i += 1
    end

  end

  private

  def dev_by_working(session, log, pass, name, surname)
    session.visit("https://dev.by/registration")
    session.fill_in('user_username',:with=>log)
    session.fill_in('user_email',:with=>log+'@mailinator.com')
    session.fill_in('user_password',:with=>pass)
    session.fill_in('user_password_confirmation',:with=>pass)
    session.fill_in('user_first_name',:with=>name)
    session.fill_in('user_last_name',:with=>surname)
    session.check('user_agreement')
    session.find('input[name="commit"]').click
  end

  def mail_working(session, log)
    session.visit("https://www.mailinator.com/")
    session.find('input[class=form-control]').set(log)
    session.find('span[class=input-group-btn]').click
    session.find('div[class=all_message-min]').click
    session.within_frame('msg_body') do
      session.find('a').click
    end
  end

end


r = Registration.new
r.get_accounts ARGV[0]
