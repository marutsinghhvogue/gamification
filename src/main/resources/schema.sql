-- Table to store questions and their options
CREATE TABLE Question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    option4 VARCHAR(255) NOT NULL,
    status StatusEnum NOT NULL DEFAULT 'ACTIVE', -- Default status is 'INACTIVE'
    correctOption VARCHAR(255) NOT NULL
);

-- Table to store users' responses to questions
CREATE TABLE UserResponse (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    questionId BIGINT NOT NULL,
    response VARCHAR(255) NOT NULL,
    isCorrect BOOLEAN NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (questionId) REFERENCES Question(id)
);

-- Table to store the winner (fastest correct responder)
CREATE TABLE Winner (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    questionId BIGINT NOT NULL,
    responseTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (questionId) REFERENCES Question(id)
);

-- Create Enum type for RewardTypeEnum
CREATE TYPE RewardTypeEnum AS ENUM ('COUPON', 'POINTS', 'CASHBACK');

-- Create Enum type for StatusEnum
CREATE TYPE StatusEnum AS ENUM ('ACTIVE', 'INACTIVE', 'STARTED', 'END');

-- Create Rewards table with a one-to-one relationship to Question
CREATE TABLE Rewards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rewardType RewardTypeEnum NOT NULL,
    rewardValue INT NOT NULL,
    question_id BIGINT UNIQUE,  -- Unique constraint for one-to-one relationship
    FOREIGN KEY (question_id) REFERENCES Question(id) ON DELETE CASCADE
);