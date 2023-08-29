func bestClosingTime(customers string) int {
    currScore, maxScore, bestHr := 0, 0, -1
    
    for i := 0; i < len(customers); i++ {
        if customers[i] == 'Y' {
            currScore++;  // If a customer arrived, increment the current score
        } else {
            currScore--;  // If not, decrement the current score
        }
        
        // Update the best closing hour and maximum score if the current score is greater
        if currScore > maxScore {
            bestHr = i  // Update the best closing hour to the current hour
            maxScore = currScore  // Update the maximum score to the current score
        }
    }

    return bestHr + 1  // Return the hour with the highest net customer count
}