namespace java gr.aschoinas.generated
	struct SampleRequest{
		1: required string name;
		2: required string lastname;
		3: required i32 age;
		4: optional string middleName;
	}

	exception SampleException {
        1: string message;
    }

    service SampleService {
            string sampleMethod(1:SampleRequest request) throws (1:SampleException validationExcecption)
    }