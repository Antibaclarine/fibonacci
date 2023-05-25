package com.example.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clearErrorsOnType()
    }

    fun clearErrorsOnType() {
        binding.etFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilFirstName.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.etLastName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilLastName.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPassword.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.etPasswordConfirmation.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPasswordConfirmation.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        castViews()

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }
    }

    fun castViews() {
        binding.tvLogin = findViewById(R.id.tv_login)
        binding.btnSignUp = findViewById(R.id.btn_sign_up)
        binding.etFirstName = findViewById(R.id.et_first_name)
        binding.etLastName = findViewById(R.id.et_last_name)
        binding.etEmail = findViewById(R.id.et_email)
        binding.etPassword = findViewById(R.id.et_password)
        binding.etPasswordConfirmation = findViewById(R.id.et_password_confirmation)
        binding.tilFirstName = findViewById(R.id.til_first_name)
        binding.tilLastName = findViewById(R.id.til_last_name)
        binding.tilEmail = findViewById(R.id.til_email)
        binding.tilPassword = findViewById(R.id.til_password)
        binding.tilPasswordConfirmation = findViewById(R.id.til_password_confirmation)
    }

    @SuppressLint("SuspiciousIndentation")
    fun validateSignUp() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val passwordConfirmation = binding.etPasswordConfirmation.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "First Name is required"
            error = true
        }

        if (lastName.isBlank()) {
            binding.tilLastName.error = "Last Name is required"
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        } else if (!validateEmail(email)) {
            binding.tilEmail.error = "Invalid email format"
            error = true
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }

        if (passwordConfirmation.isBlank()) {
            binding.tilPasswordConfirmation.error = "Password confirmation is required"
            error = true
        }

        if (password != passwordConfirmation) {
            binding.tilPasswordConfirmation.error = "Password and password confirmation do not match"
            error = true
        }

        if (!error) {
            Toast.makeText(this, "$firstName $lastName $email", Toast.LENGTH_LONG).show()
        }
    }

    fun validateEmail(email: String): Boolean {
        val pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}