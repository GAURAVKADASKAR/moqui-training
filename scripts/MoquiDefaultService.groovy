// Get the input parameters passed to the service
def trainingName = parameters.trainingName
def trainingDate = parameters.trainingDate
def trainingPrice = parameters.trainingPrice
def trainingDuration = parameters.trainingDuration

// Create a new MoquiTraining entity
def newTraining = ec.entity.make("moqui.training.MoquiTraining")
newTraining.trainingName = trainingName
newTraining.trainingDate = trainingDate
newTraining.trainingPrice = trainingPrice
newTraining.trainingDuration = trainingDuration

// Commit the new record to the database
newTraining.create()

// Set the trainingId output parameter with the new record's ID
parameters.trainingId = newTraining.trainingId