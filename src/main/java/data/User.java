package data;

import java.time.LocalDate;

    public class User {
        private long id;
        private String username;
        private String email;

        public User(long id, String username, String email, String password, LocalDate createdAt, Role role) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.createdAt = createdAt;
            this.role = role;
        }
        public User() {

        }

        private String password;
        private LocalDate createdAt;
        private Role role;
        // ...Your fields above here

        public enum Role {USER, ADMIN}

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }
//
//        public javax.management.relation.Role getRole() {
//            return role;
//        }
//
//        public Role setRole(javax.management.relation.Role role) {
//            this.role = role;
//        }
    }
