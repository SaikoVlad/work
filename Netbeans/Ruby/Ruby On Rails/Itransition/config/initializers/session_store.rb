# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_Itransition_session',
  :secret      => '59240d238ac3d0db819ec7a18e8e6f419c67934e55fcb7bcf8c1e101606a686d4be18d6f6de4a6637eb47953a5d7fa6df4984bed8b92fa0f3639f80eab256831'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
