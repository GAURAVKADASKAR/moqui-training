import org.moqui.context.ExecutionContext
import org.moqui.entity.EntityValue


def createMoquiTraining(ExecutionContext ec, String trainingName, String trainingDate) {
    

    if (!trainingName) {
        throw new IllegalArgumentException("trainingName is mandatory")
    }

    def dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy")
    dateFormat.setLenient(false)
    Date parsedDate = null
    try {
        parsedDate = dateFormat.parse(trainingDate)
    } catch (Exception e) {
        throw new IllegalArgumentException("trainingDate must follow MM/dd/yyyy format")
    }

  
    EntityValue moquiTraining = ec.entity.makeValue("moqui.training.MoquiTraining")
    moquiTraining.set("trainingName", trainingName)
    moquiTraining.set("trainingDate", parsedDate)
    moquiTraining.set("trainingPrice", trainingPrice)
    moquiTraining.set("trainingDuration", trainingDuration)


    moquiTraining.create()

   
    return moquiTraining.get("trainingId")
}

// This is an example invocation of the service in Moqui (using the service framework)
return createMoquiTraining(ec, trainingName, trainingDate,trainingPrice,trainingDuration)
