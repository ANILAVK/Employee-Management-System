-- Step 0: Drop tables if they exist (handle FK dependencies properly)
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

-- Step 1: Create 'department' table (without FK to employee)
CREATE TABLE department (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    creation_date DATE NOT NULL,
    head_id BIGINT
);

-- Step 2: Create 'employee' table
CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    salary DOUBLE NOT NULL,
    address VARCHAR(255),
    role VARCHAR(50),
    joining_date DATE NOT NULL,
    yearly_bonus_percentage DOUBLE,

    department_id BIGINT,
    manager_id BIGINT,

    CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id),
    CONSTRAINT fk_employee_manager FOREIGN KEY (manager_id) REFERENCES employee(id)
);

-- Step 3: Add FK for department head (after employee table exists)
ALTER TABLE department
ADD CONSTRAINT fk_department_head FOREIGN KEY (head_id) REFERENCES employee(id);

-- Step 4: Insert 3 departments (initially without head)
INSERT INTO department (name, creation_date) VALUES
('Engineering', '2020-01-01'),
('Sales', '2021-03-15'),
('HR', '2019-06-20');

-- Step 5: Insert employees (25 employees, some are managers)
-- Assigning department_id: 1=Engineering, 2=Sales, 3=HR
-- manager_id can be null initially or reference previous rows

INSERT INTO employee (name, date_of_birth, salary, address, role, joining_date, yearly_bonus_percentage, department_id, manager_id) VALUES
('Alice Johnson', '1990-05-10', 85000, '123 Main St', 'Software Engineer', '2021-04-01', 10.0, 1, NULL),
('Bob Smith', '1985-09-20', 95000, '234 Elm St', 'Engineering Manager', '2019-11-15', 12.0, 1, NULL),
('Charlie Davis', '1992-12-05', 70000, '456 Oak St', 'Backend Developer', '2022-01-10', 8.0, 1, 2),
('Diana Prince', '1988-08-22', 72000, '789 Pine St', 'Frontend Developer', '2021-06-20', 9.0, 1, 2),
('Ethan Hunt', '1983-01-30', 78000, '321 Birch St', 'QA Engineer', '2020-03-01', 7.5, 1, 2),

('Fiona Shaw', '1991-04-19', 68000, '111 Walnut St', 'Sales Executive', '2022-02-01', 6.5, 2, NULL),
('George White', '1986-07-11', 85000, '222 Cedar St', 'Sales Manager', '2020-05-15', 10.0, 2, NULL),
('Helen Clark', '1993-09-09', 66000, '333 Maple St', 'Account Manager', '2021-07-25', 6.0, 2, 7),
('Ian Black', '1990-03-18', 64000, '444 Chestnut St', 'Sales Rep', '2023-01-05', 5.5, 2, 7),
('Jane Green', '1987-11-02', 62000, '555 Spruce St', 'Sales Analyst', '2020-10-10', 6.0, 2, 7),

('Karl Fox', '1992-01-12', 60000, '666 Redwood St', 'HR Executive', '2022-05-01', 6.0, 3, NULL),
('Laura King', '1984-02-22', 88000, '777 Ash St', 'HR Manager', '2019-09-01', 11.0, 3, NULL),
('Mike Lee', '1995-06-06', 61000, '888 Cypress St', 'Recruiter', '2023-03-20', 5.5, 3, 12),
('Nina West', '1991-12-17', 63000, '999 Beech St', 'HR Assistant', '2021-08-11', 6.0, 3, 12),
('Oscar Bond', '1993-10-30', 65000, '1010 Hickory St', 'Payroll Specialist', '2020-04-22', 5.0, 3, 12),

-- More employees with mixed departments and reporting managers
('Paul Ray', '1990-05-01', 90000, '1111 Olive St', 'Tech Lead', '2018-12-01', 12.0, 1, 2),
('Quincy Sharp', '1989-07-14', 93000, '1212 Magnolia St', 'Architect', '2017-09-10', 11.5, 1, 2),
('Rachel Stone', '1994-11-03', 69000, '1313 Palm St', 'UI Designer', '2022-06-18', 7.0, 1, 2),
('Steve Nash', '1996-01-07', 67000, '1414 Poplar St', 'Support Engineer', '2023-04-15', 6.5, 1, 1),
('Tina Bell', '1992-03-30', 71000, '1515 Sycamore St', 'Business Analyst', '2022-12-10', 6.5, 2, 6),
('Uma Jones', '1990-06-25', 73000, '1616 Fir St', 'Operations Executive', '2020-01-20', 7.0, 2, 7),
('Victor Grey', '1985-05-12', 76000, '1717 Cedar St', 'Accountant', '2019-02-25', 8.0, 3, 12),
('Wendy Moss', '1991-10-29', 78000, '1818 Elm St', 'HR Business Partner', '2020-06-05', 8.5, 3, 12),
('Xander Hale', '1997-04-17', 75000, '1919 Birch St', 'DevOps Engineer', '2023-02-28', 6.0, 1, 1),
('Yara Knox', '1995-08-08', 77000, '2020 Redwood St', 'Trainer', '2021-09-14', 7.5, 3, 12);

-- Step 6: Update department heads (e.g., employee ids 2, 7, 12)
UPDATE department SET head_id = 2 WHERE id = 1;  -- Engineering → Bob Smith
UPDATE department SET head_id = 7 WHERE id = 2;  -- Sales → George White
UPDATE department SET head_id = 12 WHERE id = 3; -- HR → Laura King
