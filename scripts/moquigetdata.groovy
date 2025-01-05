def trainingId = parameters.trainingId
def trainingName = parameters.trainingName

def trainingdata = ec.entity.find("MoquiTraining")


if (trainingId) {
    trainingdata.condition("trainingId", trainingId)
}
if (trainingName) {
    trainingdata.condition("trainingName", trainingName)
}


def traininglist = []
def result = trainingdata.list()



return ['result': 'errorr','forname':trainingName]
